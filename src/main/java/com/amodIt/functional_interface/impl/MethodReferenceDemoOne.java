package com.amodIt.functional_interface.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.amodIt.functional_interface.UpperCaseFunctional_Interf;

public class MethodReferenceDemoOne {

	public static void main(String[] args) {
		
		// using lambda expression
		Function<Integer, Double> lambdaRef = (Integer num) -> {return Math.sqrt(num);};
		System.out.println(lambdaRef.apply(16));
		
		// same code using reference to a static method
		Function<Integer, Double> mthdRef = Math :: sqrt;
		System.out.println(mthdRef.apply(16));
		
		// addition method is the logic that we are going to pass inside under apply method.
		BiFunction<Integer, Integer, Integer> biFunLmbda= (Integer arg0, Integer arg1)->{return MethodReferenceDemoOne.addition(arg0, arg1);};
		System.out.println(biFunLmbda.apply(10, 21));
		
		// using method reference to a static method
		BiFunction<Integer, Integer, Integer> mthdRefBiFun = MethodReferenceDemoOne :: addition;
		System.out.println(mthdRefBiFun.apply(10, 32));
		
		//method to an instance reference , using first lambda expression 
		MethodReferenceDemoOne obj = new MethodReferenceDemoOne();
		UpperCaseFunctional_Interf lambdaUpperCase = (String arg1) -> {obj.m1(arg1);};
		lambdaUpperCase.upperCaseStrng("hello worlld !!!");
		
		// using method to an instance reference 
		UpperCaseFunctional_Interf mthdToInstanceRef = obj :: m1;
		mthdToInstanceRef.upperCaseStrng("amod kumar poddar");
		
		// method to a constructor reference
		List<String> fruits = new ArrayList<String>();
		fruits.add("Mango");
		fruits.add("Pomegranate");
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Guava");
		
		Function<List<String>, Set<String>> funLmbdaObj = (List<String> fruitsLit) -> {return new HashSet<String>(fruitsLit);};
		System.out.println(funLmbdaObj.apply(fruits));

	}
	
	public static Integer addition(Integer a, Integer b) {
		return (a + b);
	}
	
	public void m1(String arg0) {
		String s = arg0.toUpperCase();
		System.out.println(s);
	}

}
