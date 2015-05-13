/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Author - Sven Efftinge
 *******************************************************************************/
package example5

import org.junit.Test

import static org.junit.Assert.*

import static extension example5.Distance.*
import static extension example5.Speed.*
import static extension example5.Time.*
import static extension example5.Timers.*

/**
 * This example shows the usage of operator overloading combined with
 * extension methods.
 */
class Units {
	
	@Test def distances() {
		assertEquals(15.km, 13.km + 2_000.m)
		assertEquals(30.km, (13.km + 2_000.m) * 2)
		
		//if you implement +, you get += for free
		var distance = 10.km
		for (i: 1..10) {
			distance += i.km
		}
		assertEquals(65.km, distance)
	}
	
	@Test def time() {
		assertEquals(1.h, 65.sec + 59.min - 5_000.msec)
	}
	
	@Test def speed() {
		assertEquals(42.km/h, (40_000.m + 2.km) / 60.min)
	}
	
	@Test def void timeToSun() {
		var distanceToSun = 149_000_000.km
		
		assertEquals(distanceToSun.mm, 149_000_000.km.mm)

		var lightSpeed = 300_000.km/sec
		
		var timeToSun = distanceToSun / lightSpeed
		assertEquals(timeToSun, 496_666.msec)
	}


}


// v = s / t | * t
// v * t = s | / v
// t = s / v 