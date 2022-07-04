package TPE;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	private static String getSubjectConfirmacion(String doctor) {				
		return " ¡Turno confirmado! Turno con " + doctor;
	}
	
	private static String getSubjectCancelacion(String doctor) {				
		return " ¡Turno cancelado! Su turno con " + doctor;
	}
	
	private static String getContentConfirmacion(String paciente, String doctor, Direccion  direccion, String fecha) {
		
		return "\r\n"
				+ "    <table role=\"presentation\" style=\"opacity:1\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "        <tbody>\r\n"
				+ "          <tr>\r\n"
				+ "            <td style=\"background-color:rgb(245,245,245);padding-left:8px;padding-right:8px;padding-top:32px\" align=\"center\">\r\n"
				+ "              \r\n"
				+ "              <table role=\"presentation\" style=\"max-width:632px;margin:0 auto\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "                <tbody>\r\n"
				+ "                  <tr>\r\n"
				+ "                    <td class=\"m_-8213302373997507568o_sans\" style=\"font-family:Helvetica,Arial,sans-serif;margin-top:0px;margin-bottom:0px;font-size:16px;line-height:24px;background-color:rgb(245,245,245);border-radius:4px 4px 0px 0px;padding:24px 16px\" align=\"center\">\r\n"
				+ "                      <p style=\"margin-top:0px;margin-bottom:0px\">      \r\n"
				+ "                            <img src=\"https://i.postimg.cc/vTJxXHcZ/logo.png\" width=\"140\" height=\"122.5\">\r\n"
				+ "                          </a>\r\n"
				+ "                      </p>\r\n"
				+ "                    </td>\r\n"
				+ "                  </tr>\r\n"
				+ "                </tbody>\r\n"
				+ "              </table>\r\n"
				+ "            </td>\r\n"
				+ "          </tr>\r\n"
				+ "        </tbody>\r\n"
				+ "      </table>\r\n"
				+ "\r\n"
				+ "      <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "        <tbody>\r\n"
				+ "          <tr>\r\n"
				+ "            <td style=\"background-color:rgb(245,245,245);padding-left:8px;padding-right:8px\" align=\"center\">\r\n"
				+ "              <table style=\"max-width:632px;margin:0 auto\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "                <tbody>\r\n"
				+ "                  <tr>\r\n"
				+ "                    <td class=\"m_-8213302373997507568o_xs-py-md m_-8213302373997507568o_sans\" style=\"font-family:Helvetica,Arial,sans-serif;margin-top:0px;margin-bottom:0px;font-size:19px;line-height:28px;background-color:#ffffff;color:#82899a;padding-left:24px;padding-right:24px;padding-top:64px;padding-bottom:25px\" align=\"center\">\r\n"
				+ "                      <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "                        <tbody>\r\n"
				+ "                          <tr>\r\n"
				+ "                            <td class=\"m_-8213302373997507568o_sans\" style=\"font-family:Helvetica,Arial,sans-serif;margin-top:0px;margin-bottom:0px;font-size:16px;line-height:24px;background-color:rgb(64, 186, 181);color:rgb(255,255,255);border-radius:96px;padding:16px\" align=\"center\">\r\n"
				+ "                              <img src=\"https://ci4.googleusercontent.com/proxy/ow4KxLkTKvUHI9f9oBJmj3jAsy5p_xZOaah6fsMFkv6Q-C3uABH9rewNDRc4HKklD_5sO2J8SPAKbrhTlJMNszUJNDiicHL_EalRfgDd0DA_nbTDw0ZtKc4v3JIr0EvNZWA5pev_mUQuz4wtacccRD-TGlJ7cvs941s=s0-d-e1-ft#https://gallery.mailchimp.com/336d436794aab535ddeb48c60/images/aa9fa96d-2611-40a7-8762-912830f54ec5.png\" alt=\"\" style=\"max-width:48px;vertical-align:middle;border:0;line-height:100%;height:auto;outline:none;text-decoration:none\" width=\"48\" height=\"48\">\r\n"
				+ "                            </td>\r\n"
				+ "                          </tr>\r\n"
				+ "                          <tr>\r\n"
				+ "                            <td style=\"font-size:24px;line-height:24px;height:24px\">\r\n"
				+ "                            </td>\r\n"
				+ "                          </tr>\r\n"
				+ "                        </tbody>\r\n"
				+ "                      </table>\r\n"
				+ "                      <h2 class=\"m_-8213302373997507568o_heading\" style=\"font-family:Helvetica,Arial,sans-serif;font-weight:bold;margin-top:0px;margin-bottom:4px;color:#242b3d;font-size:30px;line-height:39px\">\r\n"
				+ "          ¡Recordatorio!<br>\r\n"
				+ "          </h2>\r\n"
				+ "                      <p style=\"margin-top:0px;margin-bottom:0px\">\r\n"
				+ "                        Recorda el <span>turno</span> de <span style=\"color:#000\">" + paciente + "</span> con <span style=\"color:#000\">" + doctor + "</span>\r\n"
				+ "                        <br>\r\n"
				+ "                      </p>\r\n"
				+ "                    </td>\r\n"
				+ "                  </tr>\r\n"
				+ "                </tbody>\r\n"
				+ "              </table>\r\n"
				+ "              \r\n"
				+ "            </td>\r\n"
				+ "          </tr>\r\n"
				+ "        </tbody>\r\n"
				+ "      </table>\r\n"
				+ "\r\n"
				+ "      <table role=\"presentation\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "        <tbody>\r\n"
				+ "          <tr>\r\n"
				+ "            <td style=\"background-color:rgb(245,245,245);padding-left:8px;padding-right:8px\" align=\"center\">\r\n"
				+ "              \r\n"
				+ "              <table role=\"presentation\" style=\"max-width:632px;margin:0 auto\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "                <tbody>\r\n"
				+ "                  <tr>\r\n"
				+ "                    <td class=\"m_-8213302373997507568o_sans\" style=\"font-family:Helvetica,Arial,sans-serif;margin-top:0px;margin-bottom:0px;font-size:14px;line-height:21px;background-color:#ffffff;color:#e9fafc;padding-left:24px;padding-right:24px;padding-top:16px;padding-bottom:16px\" align=\"center\">\r\n"
				+ "                      <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "                        <tbody>\r\n"
				+ "                          <tr>\r\n"
				+ "                            <td class=\"m_-8213302373997507568o_sans\" style=\"font-family:Helvetica,Arial,sans-serif;margin-top:0px;margin-bottom:0px;font-size:24px;line-height:30px;background-color:#ebf5fa;border-radius:4px;padding-left:8px;padding-right:8px;padding-top:24px;padding-bottom:24px\" width=\"284\" align=\"center\">\r\n"
				+ "                              <p style=\"color:#19213c;margin-top:0px;margin-bottom:0px\">\r\n"
				+ "                                <strong>" + fecha + "<br></strong>\r\n"
				+ "                              </p>\r\n"
				+ "                            </td>\r\n"
				+ "                          </tr>\r\n"
				+ "                        </tbody>\r\n"
				+ "                      </table>\r\n"
				+ "                    </td>\r\n"
				+ "                  </tr>\r\n"
				+ "                </tbody>\r\n"
				+ "              </table>\r\n"
				+ "              \r\n"
				+ "            </td>\r\n"
				+ "          </tr>\r\n"
				+ "        </tbody>\r\n"
				+ "      </table>\r\n"
				+ "\r\n"
				+ "      <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "        <tbody>\r\n"
				+ "          <tr>\r\n"
				+ "            <td style=\"background-color:rgb(245,245,245);padding-left:8px;padding-right:8px\" align=\"center\">\r\n"
				+ "              \r\n"
				+ "              <table style=\"max-width:632px;margin:0 auto\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "                <tbody>\r\n"
				+ "                  <tr>\r\n"
				+ "                    <td style=\"background-color:#ffffff;padding-left:24px;padding-right:24px\" align=\"center\">\r\n"
				+ "                      <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "                        <tbody>\r\n"
				+ "                          \r\n"
				+ "                          <tr>\r\n"
				+ "                            <td style=\"font-family:Helvetica,Arial,sans-serif;margin-top:0px;margin-bottom:0px;font-size:16px;line-height:24px;color:rgb(130,137,154);border-bottom:1px solid rgb(173, 244, 240);padding-top:16px;padding-bottom:16px;text-align:center\" width=\"450\" align=\"left\">\r\n"
				+ "                            \r\n"
				+ "                          <p style=\"margin-top:0px;margin-bottom:0px\">\r\n"
				+ "                                <span style=\"display:inline\">" + direccion.getCalle() + ' ' + direccion.getNumero() + ", " + "Tandil, Buenos Aires" + "</span>\r\n"
				+ "                              </p>\r\n"
				+ "                              \r\n"
				+ "                            </td>\r\n"
				+ "                          </tr>\r\n"
				+ "                          <td style=\"margin-top:0px;margin-bottom:0px;font-size:16px;line-height:24px;background-color:rgb(255,255,255);;padding:36px 24px\" align=\"center\">\r\n"
				+ "                            <p style=\"margin-top:0px;margin-bottom:0px\">\r\n"
				+ "                               Ante cualquier inconveniente cancele el turno con anticipacion.\r\n"
				+ "                              </p>\r\n"
				+ "                        </td>\r\n"
				+ "                        </tbody>\r\n"
				+ "                      </table>\r\n"
				+ "                    </td>\r\n"
				+ "                  </tr>\r\n"
				+ "                </tbody>\r\n"
				+ "              </table>\r\n"
				+ "            </td>\r\n"
				+ "          </tr>\r\n"
				+ "        </tbody>\r\n"
				+ "      </table>\r\n"
				+ "    \r\n"
				+ "      <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "        <tbody>\r\n"
				+ "          <tr>\r\n"
				+ "            <td class=\"m_-8213302373997507568o_xs-pb-xs\" style=\"background-color:rgb(245,245,245);padding-left:8px;padding-right:8px;padding-bottom:32px\" align=\"center\">\r\n"
				+ "              <table style=\"max-width:632px;margin:0 auto\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "                <tbody>\r\n"
				+ "                  <tr>\r\n"
				+ "                      <td style=\"padding-top:32px;font-family:Helvetica,Arial,sans-serif;margin-top:0px;margin-bottom:0px;font-size:14px;line-height:21px;background-color:#013660;color:#fff;border-radius:0px 0px 4px 4px;padding-left:24px;padding-right:24px;padding-bottom:32px\" align=\"center\">\r\n"
				+ "                        <p style=\"margin-top:0px;margin-bottom:8px\">\r\n"
				+ "                            Facultad de Ciencias Exactas UNICEN\r\n"
				+ "                          <br> Buenos Aires, Argentina </p>\r\n"
				+ "                      </td>\r\n"
				+ "                    \r\n"
				+ "                  </tr>\r\n"
				+ "                </tbody>\r\n"
				+ "              </table>\r\n"
				+ "              \r\n"
				+ "              <div class=\"m_-8213302373997507568o_hide-xs\" style=\"font-size:64px;line-height:64px;height:64px\">\r\n"
				+ "              </div>\r\n"
				+ "            </td>\r\n"
				+ "          </tr>\r\n"
				+ "        </tbody>\r\n"
				+ "      </table>";
	}
	
	private static String getContentCancelacion(String paciente, String doctor, Direccion  direccion, String fecha) {
		
		return "<table role=\"presentation\" style=\"opacity:1\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "        <tbody>\r\n"
				+ "          <tr>\r\n"
				+ "            <td style=\"background-color:rgb(245,245,245);padding-left:8px;padding-right:8px;padding-top:32px\" align=\"center\">\r\n"
				+ "              \r\n"
				+ "              <table role=\"presentation\" style=\"max-width:632px;margin:0 auto\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "                <tbody>\r\n"
				+ "                  <tr>\r\n"
				+ "                    <td class=\"m_-8213302373997507568o_sans\" style=\"font-family:Helvetica,Arial,sans-serif;margin-top:0px;margin-bottom:0px;font-size:16px;line-height:24px;background-color:rgb(245,245,245);border-radius:4px 4px 0px 0px;padding:24px 16px\" align=\"center\">\r\n"
				+ "                      <p style=\"margin-top:0px;margin-bottom:0px\">      \r\n"
				+ "                            <img src=\"https://i.postimg.cc/vTJxXHcZ/logo.png\" width=\"140\" height=\"122.5\">\r\n"
				+ "                          </a>\r\n"
				+ "                      </p>\r\n"
				+ "                    </td>\r\n"
				+ "                  </tr>\r\n"
				+ "                </tbody>\r\n"
				+ "              </table>\r\n"
				+ "            </td>\r\n"
				+ "          </tr>\r\n"
				+ "        </tbody>\r\n"
				+ "      </table>\r\n"
				+ "\r\n"
				+ "      <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "        <tbody>\r\n"
				+ "          <tr>\r\n"
				+ "            <td style=\"background-color:rgb(245,245,245);padding-left:8px;padding-right:8px\" align=\"center\">\r\n"
				+ "              <table style=\"max-width:632px;margin:0 auto\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "                <tbody>\r\n"
				+ "                  <tr>\r\n"
				+ "                    <td style=\"font-family:Helvetica,Arial,sans-serif;margin-top:0px;margin-bottom:0px;font-size:19px;line-height:28px;background-color:#ffffff;color:#82899a;padding-left:24px;padding-right:24px;padding-top:64px;padding-bottom:25px\" align=\"center\">\r\n"
				+ "                      <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "                        <tbody>\r\n"
				+ "                          <tr>\r\n"
				+ "                            <td style=\"font-family:Helvetica,Arial,sans-serif;margin-top:0px;margin-bottom:0px;font-size:16px;line-height:24px;background-color:rgb(192, 29, 29);color:rgb(255,255,255);border-radius:96px;padding:16px\" align=\"center\">\r\n"
				+ "                              <img src=\"https://i.postimg.cc/sXWqTW1F/unnamed.png\" alt=\"\" style=\"max-width:48px;vertical-align:middle;border:0;line-height:100%;height:auto;outline:none;text-decoration:none\" width=\"48\" height=\"48\">\r\n"
				+ "                              </td>\r\n"
				+ "                            </tr>\r\n"
				+ "                            <tr>\r\n"
				+ "                            <td style=\"font-size:24px;line-height:24px;height:24px\">\r\n"
				+ "                            </td>\r\n"
				+ "                          </tr>\r\n"
				+ "                        </tbody>\r\n"
				+ "                      </table>\r\n"
				+ "                      <h2 style=\"font-family:Helvetica,Arial,sans-serif;font-weight:bold;margin-top:0px;margin-bottom:4px;color:#242b3d;font-size:30px;line-height:39px\">\r\n"
				+ "          ¡Lo sentimos!<br>\r\n"
				+ "          </h2>\r\n"
				+ "                      <p style=\"margin-top:0px;margin-bottom:0px\">\r\n"
				+ "                        Le informamos que el <span>turno</span> de <span style=\"color:#000\">\" + paciente + \"</span> con <span style=\"color:#000\">\" + doctor + \"</span> ha sido cancelado.\r\n"
				+ "                        <br>\r\n"
				+ "                      </p>\r\n"
				+ "                    </td>\r\n"
				+ "                  </tr>\r\n"
				+ "                </tbody>\r\n"
				+ "              </table>\r\n"
				+ "            </td>\r\n"
				+ "          </tr>\r\n"
				+ "        </tbody>\r\n"
				+ "      </table>\r\n"
				+ "\r\n"
				+ "      <table role=\"presentation\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "        <tbody>\r\n"
				+ "          <tr>\r\n"
				+ "            <td style=\"background-color:rgb(245,245,245);padding-left:8px;padding-right:8px\" align=\"center\">  \r\n"
				+ "              <table role=\"presentation\" style=\"max-width:632px;margin:0 auto\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "                <tbody>\r\n"
				+ "                  <tr>\r\n"
				+ "                    <td style=\"font-family:Helvetica,Arial,sans-serif;margin-top:0px;margin-bottom:0px;font-size:14px;line-height:21px;background-color:#ffffff;color:#e9fafc;padding-left:24px;padding-right:24px;padding-top:16px;padding-bottom:16px\" align=\"center\">\r\n"
				+ "                      <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "                        <tbody>\r\n"
				+ "                          <tr>\r\n"
				+ "                            <td style=\"font-family:Helvetica,Arial,sans-serif;margin-top:0px;margin-bottom:0px;font-size:24px;line-height:30px;background-color:#ebf5fa;border-radius:4px;padding-left:8px;padding-right:8px;padding-top:24px;padding-bottom:24px\" width=\"284\" align=\"center\">\r\n"
				+ "                              <p style=\"color:#19213c;margin-top:0px;margin-bottom:0px\">\r\n"
				+ "                                <strong>\" + fecha + \"<br></strong>\r\n"
				+ "                              </p>\r\n"
				+ "                            </td>\r\n"
				+ "                          </tr>\r\n"
				+ "                        </tbody>\r\n"
				+ "                      </table>\r\n"
				+ "                    </td>\r\n"
				+ "                  </tr>\r\n"
				+ "                </tbody>\r\n"
				+ "              </table>\r\n"
				+ "              \r\n"
				+ "            </td>\r\n"
				+ "          </tr>\r\n"
				+ "        </tbody>\r\n"
				+ "      </table>\r\n"
				+ "\r\n"
				+ "      <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "        <tbody>\r\n"
				+ "          <tr>\r\n"
				+ "            <td style=\"background-color:rgb(245,245,245);padding-left:8px;padding-right:8px\" align=\"center\">\r\n"
				+ "              <table style=\"max-width:632px;margin:0 auto\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "                <tbody>\r\n"
				+ "                  <tr>\r\n"
				+ "                    <td style=\"background-color:#ffffff;padding-left:24px;padding-right:24px\" align=\"center\">\r\n"
				+ "                      <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "                        <tbody>   \r\n"
				+ "                          <tr>\r\n"
				+ "                            <td style=\"font-family:Helvetica,Arial,sans-serif;margin-top:0px;margin-bottom:0px;font-size:16px;line-height:24px;color:rgb(130,137,154);border-bottom:1px solid rgb(173, 244, 240);padding-top:16px;padding-bottom:16px;text-align:center\" width=\"450\" align=\"left\">       \r\n"
				+ "                          <p style=\"margin-top:0px;margin-bottom:0px\">\r\n"
				+ "                                <span style=\"display:inline\">\"\" + dirección + \" </span>\r\n"
				+ "                              </p>\r\n"
				+ "                            </td>\r\n"
				+ "                          </tr>\r\n"
				+ "                          <td style=\"margin-top:0px;margin-bottom:0px;font-size:16px;line-height:24px;background-color:rgb(255,255,255);;padding:36px 24px\" align=\"center\">\r\n"
				+ "                            <p style=\"margin-top:0px;margin-bottom:0px\">\r\n"
				+ "                               Ante cualquier inquietud comuníquese con el establecimiento.\r\n"
				+ "                              </p>\r\n"
				+ "                        </td>\r\n"
				+ "                        </tbody>\r\n"
				+ "                      </table>\r\n"
				+ "                    </td>\r\n"
				+ "                  </tr>\r\n"
				+ "                </tbody>\r\n"
				+ "              </table>\r\n"
				+ "            </td>\r\n"
				+ "          </tr>\r\n"
				+ "        </tbody>\r\n"
				+ "      </table>\r\n"
				+ "    \r\n"
				+ "      <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "        <tbody>\r\n"
				+ "          <tr>\r\n"
				+ "            <td style=\"background-color:rgb(245,245,245);padding-left:8px;padding-right:8px;padding-bottom:32px\" align=\"center\">\r\n"
				+ "              <table style=\"max-width:632px;margin:0 auto\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ "                <tbody>\r\n"
				+ "                  <tr>\r\n"
				+ "                      <td style=\"padding-top:32px;font-family:Helvetica,Arial,sans-serif;margin-top:0px;margin-bottom:0px;font-size:14px;line-height:21px;background-color:#013660;color:#fff;border-radius:0px 0px 4px 4px;padding-left:24px;padding-right:24px;padding-bottom:32px\" align=\"center\">\r\n"
				+ "                        <p style=\"margin-top:0px;margin-bottom:8px\">\r\n"
				+ "                            Facultad de Ciencias Exactas UNICEN\r\n"
				+ "                          <br> Buenos Aires, Argentina </p>\r\n"
				+ "                      </td>\r\n"
				+ "                  </tr>\r\n"
				+ "                </tbody>\r\n"
				+ "      </table>";
				
	}
	
	
    private static void send(String subject, String content, String emailPaciente) {

        String user = "turnofacilxd@gmail.com";
        String pass = "opndrdrigaapyqhq";
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();

        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
  
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }

        });
        //session.setDebug(true);

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailPaciente));
            message.setSubject(subject);
            message.setContent(content, "text/html");
            
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
    
    public static void sendConfirmacion(String emailPaciente, String paciente, String doctor, Direccion direccion, String fecha) {
    	send(getSubjectConfirmacion(doctor),getContentConfirmacion(paciente, doctor, direccion, fecha), emailPaciente );
    }

    public static void sendCancelacion(String emailPaciente, String paciente, String doctor, Direccion direccion, String fecha) {
    	send(getSubjectCancelacion(doctor),getContentCancelacion(paciente, doctor, direccion, fecha), emailPaciente );
    }

}