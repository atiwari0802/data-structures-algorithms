package arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductOfArrayElementsExceptSelfTest {

  private ProductOfArrayElementsExceptSelf productOfArrayElementsExceptSelf;

  @BeforeEach
  public void setup() {
    productOfArrayElementsExceptSelf = new ProductOfArrayElementsExceptSelf();
  }

  @Test
  public void testProductArrayLinearSpace() {
    int[] input = {1, 2, 3, 4};

    int[] answer = productOfArrayElementsExceptSelf.productLinearSpace(input);

    List<Integer> list = Arrays.stream(answer).boxed().collect(Collectors.toList());

    list.forEach(i -> System.out.printf(" %d, ", i));
  }

  @Test
  public void testProductArrayConstantSpace() {
    List<Integer> input = List.of(1, 2, 3, 4);

    List<Integer> answer = productOfArrayElementsExceptSelf.productOfArrayConstantSpace(input);

    answer.forEach(i -> System.out.printf(" %d, ", i));
  }
}
