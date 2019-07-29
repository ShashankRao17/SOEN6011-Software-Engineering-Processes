package arccostest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import arccos.ArcCos;
import org.junit.Test;



public class ArcCosTest {
  
  @Test
  public void testpiFunctionPass() {
    ArcCos a = new ArcCos();
    assertEquals(3.1413926536, a.piFunction(),0);
  }
  
  @Test
  public void testpiFunctionFail() {
    ArcCos a = new ArcCos();
    assertNotEquals(3.14139265368763546, a.piFunction(),0);
  }
  
  @Test
  public void testsquareRootPass() {
    ArcCos a = new ArcCos();
    assertEquals(2.0, a.squareRoot(4.0),0);
  }
  
  @Test
  public void testsquareRootFail() {
    ArcCos a = new ArcCos();
    assertNotEquals(2.0, a.squareRoot(9.0),0);
  }
  
  @Test
  public void powerPass() {
    ArcCos a = new ArcCos();
    assertEquals(4.0, a.power(2.0, 2),0);
  }
  
  @Test
  public void powerFail() {
    ArcCos a = new ArcCos();
    assertNotEquals(8.0, a.power(2.0, 2),0);
  }
  
  @Test
  public void calcX1Pass() {
    ArcCos a = new ArcCos();
    assertEquals(0.5773502691896257, a.calcX1(0.5),0);
  }
  
  @Test
  public void calcX1Fail() {
    ArcCos a = new ArcCos();
    assertNotEquals(0.47868, a.calcX1(0.5),0);
  }

  @Test
  public void calcX2Pass() {
    ArcCos a = new ArcCos();
    assertEquals(-0.2679491924311227, a.calcX2(-0.5),0);
  }

  @Test
  public void calcX2Fail() {
    ArcCos a = new ArcCos();
    assertNotEquals(-0.254398673, a.calcX2(-0.5),0);
  }

  @Test
  public void acosPass() {
    ArcCos a = new ArcCos();
    assertEquals(1.0471977681676936, a.acos(0.5),0);
  }

  @Test
  public void acosFail() {
    ArcCos a = new ArcCos();
    assertNotEquals(1.0576837263, a.acos(0.5),0);
  } 

}
