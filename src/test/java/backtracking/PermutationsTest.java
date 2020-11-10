package backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PermutationsTest {

  private Permutations permutations;

  @BeforeEach
  public void setup() {
    permutations = new Permutations();
  }

  @Test
  public void testGetAllPermutations() {
    int[] nums = {1, 2, 3};

    List<List<Integer>> output = permutations.permute(nums);

    for (List<Integer> list : output) {
        for (int i : list) {
            System.out.printf(" %d ", i);
        }
        System.out.println();
    }
  }

  static class DomainObject {
      String str;

      public DomainObject(String str) {
          this.str = str;
      }
  }

  @Test
  public void testReferences() {
      List<DomainObject> domainObjects = new ArrayList<>();

      DomainObject domainObject1 = new DomainObject("ABC");
      DomainObject domainObject2 = new DomainObject("DEF");

      domainObjects.add(domainObject1);
      domainObjects.add(domainObject2);

      domainObject1.str = "XYZ";

      domainObjects.forEach(domainObject -> System.out.printf(" %s ", domainObject.str));
  }
}
