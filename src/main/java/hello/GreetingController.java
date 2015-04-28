package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    
    @RequestMapping("/index")
    public String index(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
    
    @RequestMapping("/configure")
    public String configure(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "underConstruction";
    }
    
    @RequestMapping("/discover")
    public String discover(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "underConstruction";
    }
    
    @RequestMapping("/history")
    public String history(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "underConstruction";
    }
    
    @RequestMapping("/filterHistory")
    public String filterHistory(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "underConstruction";
    }
    
    @RequestMapping("/submitTicker")
    public String submitTicker(@RequestParam(value="ticker", required=false, defaultValue="EMC") String ticker, Model model) {
        model.addAttribute("ticker", ticker);
        
        String url;
    	String configType="growth";
    	//String ticker="jpm";
        RestTemplate restTemplate = new RestTemplate();
        
        url = "https://analyze-stock.appspot.com/_ah/api/stockAnalyzer/v1/stockAnalyzer?configType="
          	  + configType + "&ticker=" + ticker;
        TickerData td = restTemplate.getForObject( 
          		url
          //		"https://analyze-stock.appspot.com/_ah/api/stockAnalyzer/v1/stockAnalyzer?configType=growth&ticker=emc"
          		, TickerData.class);
        System.out.println("*** TickerData for " + td.getTickerName() + " at  " + td.getPrice() 
          		  + ",yield=" + td.getDivYield() 
          		  + ",pe=" + td.getPe()
          		  + ",isPeOk=" + td.getIsPeOk()
          		  +",qRevGrowth= "+ td.getQRevGrowth()
          		  + ", recommendation=" + td.getRecommendation()  );
        
        model.addAttribute("tickerName", td.getTickerName());  
        model.addAttribute("price", td.getPrice());
        model.addAttribute("yield", td.getDivYield());
        model.addAttribute("pe", td.getPe());
        model.addAttribute("isPeOk", td.getIsPeOk());
        model.addAttribute("recommendation", td.getRecommendation());
       
        return "results";
    }
    
    @RequestMapping("/getMacroEconData")
    public String macroData(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "macroData";
    }
    
}
