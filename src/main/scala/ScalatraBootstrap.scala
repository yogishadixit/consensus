import com.github.yogishadixit.consensus._
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new UserServlet, "/users/*")
    context.mount(new ConsensusServlet, "/*")
  }
}
