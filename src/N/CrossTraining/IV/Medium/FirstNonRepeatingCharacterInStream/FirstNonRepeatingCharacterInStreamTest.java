package N.CrossTraining.IV.Medium.FirstNonRepeatingCharacterInStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstNonRepeatingCharacterInStreamTest {
  private static FirstNonRepeatingCharacterInStream instance;

  @BeforeAll
  static void setInstance() {
    instance = new FirstNonRepeatingCharacterInStream();
  }

  @BeforeEach
  void setUp() {
  }

  @Test
  void read() {
    // Test with reading 'a', 'b', 'c', and 'd'
    instance.read('a');
    instance.read('b');
    instance.read('c');
    instance.read('d');
  }

  @Test
  void firstNonRepeating() {
    // Empty stream
    assertNull(instance.firstNonRepeating());

    // The current stream is ['a', 'b', 'c', 'd']
    read();
    assertEquals('a', instance.firstNonRepeating());

    // Read another 'a'
    instance.read('a');
    assertEquals('b', instance.firstNonRepeating());

    // Read another 'c'
    instance.read('c');
    assertEquals('b', instance.firstNonRepeating());

    // Read another 'c'
    instance.read('c');
    assertEquals('b', instance.firstNonRepeating());

    // Read another 'b'
    instance.read('b');
    assertEquals('d', instance.firstNonRepeating());
  }
}