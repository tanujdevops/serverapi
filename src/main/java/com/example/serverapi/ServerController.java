package com.example.serverapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/servers")
public class ServerController {

    @Autowired
    private ServerRepository serverRepository;

    @GetMapping
    public List<Server> getServers(@RequestParam(required = false) String id) {
        if (id != null) {
            Optional<Server> server = serverRepository.findById(id);
            if (server.isPresent()) {
                return List.of(server.get());
            } else {
                System.out.println("Error 404");
                return null;
            }
        } else {
            return serverRepository.findAll();
        }
    }

    @PutMapping
    public Server putServer(@RequestBody Server server) {
        Server s = serverRepository.save(server);
        log.info("s", s);
        return s;
    }

    @DeleteMapping("/{id}")
    public void deleteServer(@PathVariable String id) {
        serverRepository.deleteById(id);
    }

    @GetMapping("/search")
    public List<Server> searchServersByName(@RequestParam String name) {
        List<Server> servers = serverRepository.findByNameContainingIgnoreCase(name);
        if (servers.isEmpty()) {
            System.out.println("Error 404");
            return null;
        } else {
            return servers;
        }
    }
}
