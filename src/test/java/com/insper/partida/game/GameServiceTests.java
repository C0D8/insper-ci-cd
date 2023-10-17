package com.insper.partida.game;


import com.insper.partida.equipe.Team;
import com.insper.partida.equipe.TeamService;
import com.insper.partida.game.dto.GameReturnDTO;
import com.insper.partida.game.dto.SaveGameDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GameServiceTests {



    @InjectMocks
    GameService gameService;

    @Mock
    GameRepository gameRepository;

    @Mock
    TeamService teamService;



    @Test
    void test_saveGame() {
        SaveGameDTO saveGameDTO = new SaveGameDTO();
        saveGameDTO.setHome("home");
        saveGameDTO.setAway("away");

        // Simule o comportamento do TeamService
        Mockito.when(teamService.getTeam("home")).thenReturn(new Team());
        Mockito.when(teamService.getTeam("away")).thenReturn(new Team());

        // Simule o comportamento do GameRepository
        Mockito.when(gameRepository.save(Mockito.any())).thenAnswer(invocation -> invocation.getArgument(0));

        GameReturnDTO resp = gameService.saveGame(saveGameDTO);

        Assertions.assertNotNull(resp);
        Assertions.assertEquals("home", resp.getHome());
        Assertions.assertEquals("away", resp.getAway());
    }


}
