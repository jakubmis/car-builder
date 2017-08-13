package ly.phenoma.task.model.car;

import ly.phenoma.task.model.transmission.ManualTransmission;
import ly.phenoma.task.model.wheel.Wheel15;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class BasicCarTest {

    @Mock
    private ManualTransmission manualTransmission;

    @Mock
    private Wheel15 wheel15;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void price() throws Exception {
        when(wheel15.price()).thenReturn(11.3f);
        when(manualTransmission.price()).thenReturn(22.9f);
        BasicCar basicCar = BasicCar.builder()
                .items(asList(manualTransmission, wheel15))
                .build();
        assertEquals(11.3f + 22.9f, basicCar.price(), 0.1f);
    }

}