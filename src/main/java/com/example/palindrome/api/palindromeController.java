package com.example.palindrome.api;

import com.example.palindrome.model.PalindromeInput;
import com.example.palindrome.service.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/palindrome")
@RestController
public class palindromeController {
    final private PalindromeService palindromeService;

    @Autowired
    public palindromeController(PalindromeService palindromeService) {
        this.palindromeService = palindromeService;
    }

    @PostMapping
    public String newPalindrome(@RequestBody PalindromeInput input){
        return palindromeService.checkPalindrome(input.getInput());
    }

}
