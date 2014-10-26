import com.ordonteam.custom.CustomMazeGenerator
import com.ordonteam.model.controllers.BotController
import com.ordonteam.model.controllers.ShadowController
import com.ordonteam.model.drawables.Bot
import com.ordonteam.model.drawables.Maze
import com.ordonteam.model.drawables.NoShadow
import com.ordonteam.model.drawables.Shadow
import pl.polidea.robospock.RoboSpecification

class BotControllerSpec extends RoboSpecification {

    Maze maze
    ShadowController shadowController

    def "setup"() {
        maze = new CustomMazeGenerator(10, 10).generate()
        shadowController = new ShadowController(maze,Shadow.noShadow())
    }

    def "should create maze and shadow controller"() {
        expect:
        maze != null
        shadowController != null
    }

    def "should create botController"() {
        given:
        BotController botController = new BotController(new Bot())
        expect:
        botController != null
    }

}