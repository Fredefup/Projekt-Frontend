/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ahmed Sadiq
 */
public interface Command
{
  String execute(HttpServletRequest req);
  
}
