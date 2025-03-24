package com.example.demo.service;

import com.example.demo.entity.DemoEntry;
import com.example.demo.entity.User;
import com.example.demo.repository.DemoEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class DemoEntryService {

    @Autowired
    private DemoEntryRepository demoEntryRepository;

    @Autowired
    private UserService userService;


    public List<DemoEntry> getAllEntries() {
        return demoEntryRepository.findAll();
    }

    public Optional<DemoEntry> getEntryById(ObjectId id) {
        return demoEntryRepository.findById(id);
    }

    @Transactional
    public void saveEntry(DemoEntry entry, String username) {
        try {
            User user = userService.findByUsername(username);

            LocalDate localDate = LocalDate.now();
            Date date = Date.from(localDate.atStartOfDay(ZoneId.of("UTC")).toInstant());
            entry.setDate(date);

            DemoEntry saved = demoEntryRepository.save(entry);
            user.getDemoEntries().add(saved);
            userService.saveUser(user);
        }
        catch (Exception e){
            throw new RuntimeException("An error occured while saving the entry" + e);
        }
    }

    public DemoEntry updateEntry(ObjectId id, DemoEntry newEntry, String username) {
        User user = userService.findByUsername(username);
        DemoEntry oldEntry = demoEntryRepository.findById(id).orElseThrow(() -> new RuntimeException("Entry not found"));

        if(oldEntry!=null){
            oldEntry.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().isEmpty() ? newEntry.getTitle() : oldEntry.getTitle());
            oldEntry.setContent(newEntry.getContent() != null && !newEntry.getTitle().isEmpty() ? newEntry.getContent() : oldEntry.getContent());
        }
        return demoEntryRepository.save(oldEntry);
    }

    @Transactional
    public boolean deleteEntry(ObjectId id, String username) {
        try{
            User user = userService.findByUsername(username);
            boolean removed = user.getDemoEntries().removeIf(x -> x.getId().equals(id));
            if(removed){
                userService.saveUser(user);
                demoEntryRepository.deleteById(id);
                return true;
            }
            return false;
        }
        catch (Exception e){
            log.error("Error: ", e);
            throw new RuntimeException("An error occured while deleting the entry.", e);
        }
    }
}
