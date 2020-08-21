package com.example.palindrome.service;

import com.example.palindrome.dao.MaxPalindromeDao;
import com.example.palindrome.model.PalindromeInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Service
public class PalindromeService {
    private final MaxPalindromeDao maxPalindromeDao;

    @Autowired
    public PalindromeService(@Qualifier("palindrome") MaxPalindromeDao maxPalindromeDao) {
        this.maxPalindromeDao = maxPalindromeDao;
    }

    public String checkPalindrome(String input) {


            int n = input.length();
            boolean table[][] = new boolean[n][n];

            // length 1 always return true
            for (int i = 0; i < n; ++i)
                table[i][i] = true;

            // mark the tart and end of the string
            int start = 0;
            int end = 1;

            // length 2 check
            for (int i = 0; i < n - 1; i++) {
                if (input.charAt(i) == input.charAt(i + 1)) {
                    table[i][i + 1] = true;
                    start = i;
                    end = 2;
                }
            }

            // above 2
            for (int k = 3; k <= n; k++) {
                for (int i = 0; i < n - k + 1; i++) {
                    int j = i + k - 1;
                    if (input.charAt(i) == input.charAt(j) && table[i + 1][j - 1]) {
                        table[i][j] = true;
                        if (k > end) {
                            start = i;
                            end = k;
                        }
                    }
                }
            }

        String result = input.substring(start, start+end);

        maxPalindromeDao.addNewMax(result);
        return result;
    }
}
