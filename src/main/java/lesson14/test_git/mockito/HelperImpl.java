package lesson14.test_git.mockito;

public class HelperImpl implements Helper {
    @Override
    public Integer someHelperMethod(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public void anotherHelperMethod(Integer a, Integer b) {
        System.out.println(a + " " + b);
    }
}
