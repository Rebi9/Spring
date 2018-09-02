@Grab("thymeleaf-spring5")

@Controller
class App {
  @RequestMapping("/")
  @ResponseBody
  def home(ModelAndView mav) {
    mav.setViewName("home")
    mav.addObject("msg","Hello! this is sample page.")
    mav
  }
}
