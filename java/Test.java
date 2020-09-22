import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

public class Test {
    @Autowired
    private ConversionService conversionService;
    @org.junit.Test
    public void simpleConversion(){
        DefaultConversionService cs=new DefaultConversionService();
       assert(cs.convert("25",Integer.class)).equals(25);
    }
}
