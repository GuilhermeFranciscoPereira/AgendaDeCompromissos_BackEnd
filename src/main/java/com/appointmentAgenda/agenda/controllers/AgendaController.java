package com.appointmentAgenda.agenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appointmentAgenda.agenda.dtos.AgendaRequest;
import com.appointmentAgenda.agenda.dtos.AgendaResponse;
import com.appointmentAgenda.agenda.services.AgendaService;

@CrossOrigin
@RestController
@RequestMapping("agenda")
public class AgendaController {
    @Autowired
    private AgendaService service;

    @GetMapping
    public ResponseEntity<List<AgendaResponse>> getAgendas() {
        return ResponseEntity.ok(service.getAllAgenda());
    }

    @GetMapping("{id}")
    public ResponseEntity<AgendaResponse> getAgenda(@PathVariable long id) {
        return ResponseEntity.ok(service.getAgendaById(id));
    }

    @PostMapping()
    public ResponseEntity<AgendaResponse> saveProduct(@RequestBody AgendaRequest agenda ) {
        AgendaResponse newAgenda = service.saveNewAgenda(agenda);
        return ResponseEntity.created(null).body(newAgenda);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateAgenda(@PathVariable long id, @RequestBody AgendaRequest agenda) {
        service.uptade(agenda, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
