package ly.phenoma.task.factory;

import ly.phenoma.task.model.display.Display;
import ly.phenoma.task.model.display.IPSDisplay;
import ly.phenoma.task.model.display.TFTDisplay;
import ly.phenoma.task.model.display.TNDisplay;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.BeanFactory;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class DisplayFactoryTest {

    @Mock
    private BeanFactory beanFactory;
    private DisplayFactory displayFactory;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        displayFactory = new DisplayFactory(beanFactory);
    }

    @Test
    public void getIPS() throws Exception {
        when(beanFactory.getBean(eq(IPSDisplay.class), any())).thenReturn(new IPSDisplay(5.2f));
        String IPS_DISPLAY = "IPS 5.2";
        Display display = displayFactory.get(IPS_DISPLAY);
        assertNotNull(display);
        assertTrue(display instanceof IPSDisplay);
    }

    @Test
    public void getTFT() throws Exception {
        when(beanFactory.getBean(eq(TFTDisplay.class), any())).thenReturn(new TFTDisplay(5.2f));
        String TFT_DISPLAY = "TFT 5.2";
        Display display = displayFactory.get(TFT_DISPLAY);
        assertNotNull(display);
        assertTrue(display instanceof TFTDisplay);
    }

    @Test
    public void getTN() throws Exception {
        when(beanFactory.getBean(eq(TNDisplay.class), any())).thenReturn(new TNDisplay(5.2f));
        String TN_DISPLAY = "TN 5.2";
        Display display = displayFactory.get(TN_DISPLAY);
        assertNotNull(display);
        assertTrue(display instanceof TNDisplay);
    }

    @Test
    public void getUndefined() throws Exception {
        Display display = displayFactory.get("Undefined");
        assertNull(display);
    }

    @Test
    public void getDisplayWithWrongData() throws Exception {
        Display display = displayFactory.get("TN abc");
        assertNull(display);
    }

}