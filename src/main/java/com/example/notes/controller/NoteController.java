package com.example.notes.controller;

import com.example.notes.model.Note;
import com.example.notes.service.NoteService;
import com.google.common.collect.ImmutableMap;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    NoteService noteService;



    @GetMapping("/v1/notes")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<?> getAllNotes() {
        List<Note> note = noteService.getNotes();

        ImmutableMap<String, Object> dataMap = ImmutableMap.of("status", 200,
                "message", "success", "data", note);
        return ResponseEntity.ok().body(dataMap);
    }



    @PostMapping("/v1/notes")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<?> createNote(@Valid @RequestBody Note note) {
        Note noteDetails = noteService.save(note);
        ImmutableMap<String, Object> dataMap = ImmutableMap.of("status", 201,
                "message", "Note updated successfully", "data", noteDetails);
        return ResponseEntity.status(201).body(dataMap);
    }



    @GetMapping("/v1/notes/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<?> getNoteById(@PathVariable(value = "id") Long noteId) {
        Note note = noteService.getNoteById(noteId);
        ImmutableMap<String, Object> dataMap = ImmutableMap.of("status", 200,
                "message", "success", "data", note);
        return ResponseEntity.ok().body(dataMap);
    }



    @PutMapping("/v1/notes/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public  ResponseEntity<?> updateNote(@PathVariable(value = "id") Long noteId,
                           @Valid @RequestBody Note noteDetails) {
        Note updatedNote = noteService.update(noteId, noteDetails);
        ImmutableMap<String, Object> dataMap = ImmutableMap.of("status", 200,
                "message", "Note updated successfully", "data", updatedNote);
        return ResponseEntity.ok().body(dataMap);
    }



    @DeleteMapping("/v1/notes/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        noteService.delete(noteId);
        ImmutableMap<String, Object> dataMap = ImmutableMap.of("status", 200,
                "message", "Note Deleted successfully");
        return ResponseEntity.ok().body(dataMap);
    }




    @GetMapping("/v2/notes")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<?> getAllNotesV2() {
        List<Note> note = noteService.getNotes();

        ImmutableMap<String, Object> dataMap = ImmutableMap.of("status", 200,
                "message", "success", "data", note);
        return ResponseEntity.ok().body(dataMap);
    }



    @GetMapping(value = "/notes", params = "version=3")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<?> getAllNotesV3() {
        List<Note> note = noteService.getNotes();

        ImmutableMap<String, Object> dataMap = ImmutableMap.of("status", 200,
                "message", "success", "data", note);
        return ResponseEntity.ok().body(dataMap);
    }



    @GetMapping(value = "/notes/header", headers = "X-API-VERSION=4")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<?> getAllNotesV4() {
        List<Note> note = noteService.getNotes();

        ImmutableMap<String, Object> dataMap = ImmutableMap.of("status", 200,
                "message", "success", "data", note);
        return ResponseEntity.ok().body(dataMap);
    }



    @GetMapping(value = "/notes/produces", produces = "application/vnd.company.app-v5+json")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<?> getAllNotesV5() {

        List<Note> note = noteService.getNotes();

        ImmutableMap<String, Object> dataMap = ImmutableMap.of("status", 200,
                "message", "success", "data", note);
        return ResponseEntity.ok().body(dataMap);
    }
}
