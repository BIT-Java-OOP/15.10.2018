import converter.Converter
import model.Game
import model.Player
import spock.lang.Specification

class ConverterTest extends Specification {

    Integer gameCost
    String gameName

    def setup(){
        gameCost = 12
        gameName = "gamcio 3"
    }

    def 'check if it works for simple data'(){
        given:
        def converter = new Converter<Game>(Game.class)

        Map<String, Object> map = new HashMap<>()
        map.put("name", gameName)
        map.put("cost", gameCost)

        when:
        def game = converter.getConvertedData(map)

        then:
        gameCost.equals(game.getCost())
        gameName.equals(game.getName())

        and:
        noExceptionThrown()
    }

    def 'check if it works for advanced data'(){
        given:
        def converter = new Converter<Player>(Player.class)

        Map<String, Object> map = new HashMap<>()
        String playerName = "player1"
        Integer playerAge = 18
        Game game = new Game(gameName, gameCost)

        map.put("name", playerName)
        map.put("age", playerAge)
        map.put("game", game)

        when:
        def player = converter.getConvertedData(map)

        then:
        playerName.equals(player.getName())
        playerAge.equals(player.getAge())
        game.equals(player.getGame())

        and:
        noExceptionThrown()
    }
}
