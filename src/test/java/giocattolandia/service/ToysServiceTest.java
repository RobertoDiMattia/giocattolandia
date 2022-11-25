package giocattolandia.service;

import giocattolandia.model.Toys;
import giocattolandia.repository.ToysRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ToysServiceTest {

    @InjectMocks
    private ToysService toysService;

    @Mock
    ToysRepository toysRepository;

    @Test
    public void shouldRetrieveSingleUsers() {
        given(toysRepository.findById(1L)).willReturn(Optional.of(getToys()));
        Assertions.assertThat(toysService.retrieveToysById(1L)).isNotNull();
    }

    private Toys getToys() {
        return new Toys(1L,"Nemo",20,new BigDecimal(15),new BigDecimal(10),78945L,true);
    }

}
