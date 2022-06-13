//package com.nology;
//
//import java.util.List;
//
//@RestController
//public class Controller {
//
//    @AutoWired
//    ClientService clientservice;
//
//    @GetMapping("/price/{id}")
//    public ResponseEntity<Price> getPriceById(@PathVariable String id) {
//        return ResponseEntity.status(HttpStatus.OK).body(clientservice.findById(Integer.parseInt(id)));
//    }
//
//    @GetMapping("/prices")
//    public ResponseEntity<List<Price>> getPrices() {
//        return ResponseEntity.status(HttpStatus.OK).body(clientservice.findAll());
//    }
//
//
//}
