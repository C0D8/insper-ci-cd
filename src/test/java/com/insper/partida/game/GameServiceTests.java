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

        Team fla = new Team();
        Team vas = new Team();
        fla.setIdentifier("Fla");
        vas.setIdentifier("Vas");

        SaveGameDTO saveGameDTO = new SaveGameDTO();
        saveGameDTO.setHome(fla.getIdentifier());
        saveGameDTO.setAway(vas.getIdentifier());


        Mockito.when(teamService.getTeam(saveGameDTO.getHome())).thenReturn(fla);
        Mockito.when(teamService.getTeam(saveGameDTO.getHome())).thenReturn(vas);


        GameReturnDTO resp = gameService.saveGame(saveGameDTO);


        Assertions.assertEquals(fla.getIdentifier(), resp.getHome());
        Assertions.assertEquals(vas.getIdentifier(), resp.getAway());
    }


}
