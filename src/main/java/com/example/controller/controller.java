package com.example.controller;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class controller {

	@PostMapping("/freq")
	public Map<String,Integer> freq(@RequestBody Map<String,String> input){
		String txt=input.get("text").toLowerCase();
		StringBuilder bs=new StringBuilder();
		for(char c: txt.toCharArray()) {
			if(Character.isLetter(c)|| Character.isWhitespace(c)) {
				bs.append(c);
			}
		}
		String[] words=bs.toString().split("\\s+");
		Map<String,Integer> mp=new TreeMap<>();
		for(String word:words) {
			if(mp.containsKey(word)) {
				int count=mp.get(word);
				mp.put(word, count+1);
			}
			else{
				mp.put(word, 1);
			}
		       
		}
		return mp;
	}
}
