/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Suhu;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
public class ProjectController {
        private int temperaturekelvin(int temperaturecelcius){
        int temperaturekelvin = (int) (temperaturecelcius + 273.15);
        return temperaturekelvin;
    }
	
	private int temperaturefahrenheit(int temperaturecelcius){
        int temperaturefahrenheit = (temperaturecelcius*9/5)+32;
        return temperaturefahrenheit;
    }
	
	private int temperaturereamur(int temperaturecelcius){
        int temperaturereamur = temperaturecelcius *4/5;
        return temperaturereamur;
    }
    @RequestMapping("/suhutemp")
    //@ResponseBody
    public String getHasil(HttpServletRequest data, Model datas){
       String getnametemperature = data.getParameter("nametemperature");
       int gettemperaturecelcius = Integer.parseInt(data.getParameter("temperaturecelcius")); 
      
       int temperaturereamur = temperaturereamur(gettemperaturecelcius);
       int temperaturekelvin = temperaturekelvin(gettemperaturecelcius);
       int temperaturefahrenheit = temperaturefahrenheit(gettemperaturecelcius);
       
       datas.addAttribute("temperaturekelvin", temperaturekelvin);
       datas.addAttribute("temperaturefahrenheit", temperaturefahrenheit);
       datas.addAttribute("temperaturecelcius", gettemperaturecelcius);
       datas.addAttribute("temperaturereamur", temperaturereamur);
       
       
       return "result";
    }
}