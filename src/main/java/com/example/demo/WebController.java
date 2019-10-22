package com.example.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @RequestMapping("/liczbaMalychLiter")
    public String maleLitery(@RequestParam(value = "name", defaultValue = "Robot") String name) {
        Sample sample = new Sample();
        char[] charArray = name.toCharArray();
        for (char c : charArray) {
            if (Character.isLowerCase(c)) {
                sample.setLiczbaMalychLiter(sample.getLiczbaMalychLiter() + 1);
            }

        }
        sample.setMessage(name);
        return "Liczba malych liter to: " + sample.getLiczbaMalychLiter();
    }

    @RequestMapping("/liczbaDuzychLiter")
    public String duzeLitery(@RequestParam(value = "name", defaultValue = "Robot") String name) {
        Sample sample = new Sample();
        char[] charArray = name.toCharArray();
        for (char c : charArray) {
            if (Character.isUpperCase(c)) {
                sample.setLiczbaDuzychLiter(sample.getLiczbaDuzychLiter() + 1);
            }
        }
        sample.setMessage(name);
        return "Liczba duzych liter to: " + sample.getLiczbaDuzychLiter();
    }

    @RequestMapping("/liczbaLiczb")
    public String liczbaLiczb(@RequestParam(value = "name", defaultValue = "Robot") String name) {
        Sample sample = new Sample();
        char[] charArray = name.toCharArray();
        for (char c : charArray) {
            if (Character.isDigit(c)) {
                sample.setLiczbaLiczb(sample.getLiczbaLiczb() + 1);
            }
        }
        sample.setMessage(name);
        return "Liczba liczb to: " + sample.getLiczbaLiczb();
    }

    @RequestMapping("/liczbaZnakowSpecjalnych")
    public String znakiSpecjalne(@RequestParam(value = "name", defaultValue = "Robot") String name) {
        Sample sample = new Sample();
        char[] charArray = name.toCharArray();
        for (char c : charArray) {
            if (czyZnakSpecjalny(c)) {
                sample.setLiczbaZnakowSpecjalnych(sample.getLiczbaZnakowSpecjalnych() + 1);
            }
        }
        sample.setMessage(name);
        return "Liczba znakow specjalnych to: " + sample.getLiczbaZnakowSpecjalnych();
    }

    public boolean czyZnakSpecjalny(char c) {
        Pattern pattern = Pattern.compile("[!@#$%^&*]");
        Matcher match = pattern.matcher(String.valueOf(c));
        return match.find();

    }
}
