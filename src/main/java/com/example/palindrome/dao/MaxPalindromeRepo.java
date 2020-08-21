package com.example.palindrome.dao;


import com.example.palindrome.model.PalindromeInput;
import org.springframework.stereotype.Repository;

@Repository("palindrome")
public class MaxPalindromeRepo implements MaxPalindromeDao {

    //implement DB here
    private static String DB;

    @Override
    public int addNewMax(String input) {
        DB = input;
        return 1;
    }
}
