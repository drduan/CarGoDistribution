package com.neusoft.cargo.test;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import com.neusoft.cargo.entity.User;

public class CarTest {
	private static Validator validator;

	   @BeforeClass
	   public static void setUp() {
	      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	      validator = factory.getValidator();
	   }

	   @Test
	   public void manufacturerIsNull() {
	      User car = new User( "ASd", "DD-AB-123"," 155664117","33", "142232199308104814", "22" );

	      Set<ConstraintViolation<User>> constraintViolations =
	      validator.validate( car );

	      assertEquals( 1, constraintViolations.size() );
//	      assertEquals(
//	         "may not be null",
//	         constraintViolations.iterator().next().getMessage()
//
//	      );
	   }

//	   @Test
//	   public void licensePlateTooShort() {
//		   User car = new User( "Morris", "D", 4 );
//
//	      Set<ConstraintViolation<User>> constraintViolations =
//	      validator.validate( car );
//
//	      assertEquals( 1, constraintViolations.size() );
//	      assertEquals(
//	         "size must be between 2 and 14",
//	         constraintViolations.iterator().next().getMessage()
//	      );
//	   }
//
//	   @Test
//	   public void seatCountTooLow() {
//		   User car = new User( "Morris", "DD-AB-123", 1 );
//
//	      Set<ConstraintViolation<User>> constraintViolations =
//	      validator.validate( car );
//
//	      assertEquals( 1, constraintViolations.size() );
//	      assertEquals(
//	         "must be greater than or equal to 2",
//	         constraintViolations.iterator().next().getMessage()
//	      );
//	   }
//
//	   @Test
//	   public void carIsValid() {
//		   User car = new User( "Morris", "DD-AB-123", 2 );
//
//	      Set<ConstraintViolation<User>> constraintViolations =
//	      validator.validate( car );
//
//	      assertEquals( 0, constraintViolations.size() );
//	   }
}
