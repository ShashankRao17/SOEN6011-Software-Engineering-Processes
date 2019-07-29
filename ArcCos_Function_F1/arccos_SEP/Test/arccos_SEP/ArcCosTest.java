package arccos_SEP;

import static org.junit.Assert.*;

import org.junit.Test;

import arccos.ArcCos;

public class ArcCosTest {
	
	static double _pi=3.1415926536;
	@Test
	public void testsquareRootPass() {
		ArcCos A=new ArcCos();
		assertEquals(2.0, A.squareRoot(4.0),0);
	}
	
	@Test
	public void testsquareRootFail() {
		ArcCos A=new ArcCos();
		assertNotEquals(2.0, A.squareRoot(9.0),0);
	}
	
	@Test
	public void powerPass() {
		ArcCos A=new ArcCos();
		assertEquals(4.0, A.power(2.0, 2),0);
	}
	
	@Test
	public void powerFail() {
		ArcCos A=new ArcCos();
		assertNotEquals(8.0, A.power(2.0, 2),0);
	}
	
	@Test
	public void calcX1Pass() {
		ArcCos A=new ArcCos();
		assertEquals(0.5773502691896257, A.calcX1(0.5),0);
	}
	
	@Test
	public void calcX1Fail() {
		ArcCos A=new ArcCos();
		assertNotEquals(0.47868, A.calcX1(0.5),0);
	}
	
	@Test
	public void calcX2Pass() {
		ArcCos A=new ArcCos();
		assertEquals(-0.2679491924311227, A.calcX2(-0.5),0);
	}
	
	@Test
	public void calcX2Fail() {
		ArcCos A=new ArcCos();
		assertNotEquals(-0.254398673, A.calcX2(-0.5),0);
	}
	
	@Test
	public void acosPass() {
		ArcCos A=new ArcCos();
		assertEquals(1.0471977681676936, A.acos(0.5),0);
	}
	
	@Test
	public void acosFail() {
		ArcCos A=new ArcCos();
		assertNotEquals(1.0576837263, A.acos(0.5),0);
	} 

}
