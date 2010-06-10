package com.t11e.discovery.datatool;

import java.net.URL;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.bio.SocketConnector;
import org.mortbay.jetty.handler.ContextHandlerCollection;
import org.mortbay.jetty.webapp.WebAppContext;

public class WebServerMain
{
  public static void main(final String[] args)
  {
    if (args.length != 1)
    {
      System.err.println("Usage: " + WebServerMain.class.getName() + " [address:]port");
      System.exit(1);
    }
    try
    {
      final WebServerMain main = new WebServerMain(args[0]);
      main.start();
    }
    catch (final Exception e)
    {
      System.err.println(e.getMessage());
      System.exit(1);
    }
  }

  private Server server;

  public WebServerMain(final String address)
  {
    this(address, null);
  }

  public WebServerMain(final String address, final String warPath)
  {
    init(address, warPath != null ? warPath : findWarPath());
  }

  private void init(final String address, final String warPath)
  {
    server = new Server();
    final ContextHandlerCollection contexts = new ContextHandlerCollection();
    server.setHandler(contexts);

    final SocketConnector connector = new SocketConnector();
    {
      final int colon = address.lastIndexOf(':');
      if (colon < 0)
      {
        connector.setPort(Integer.parseInt(address));
      }
      else
      {
        connector.setHost(address.substring(0,colon));
        connector.setPort(Integer.parseInt(address.substring(colon+1)));
      }
    }
    server.setConnectors(new Connector[]{connector});

    final WebAppContext webapp = new WebAppContext();
    webapp.setWar(warPath);
    webapp.setContextPath("/");
    contexts.addHandler(webapp);
  }

  public void start()
    throws Exception
  {
    server.start();
  }

  public void stop()
    throws Exception
  {
    server.stop();
  }

  public void destroy()
  {
    server.destroy();
    server = null;
  }

  private String findWarPath()
  {
    final String resourceName = WebServerMain.class.getName().replace('.', '/') + ".class";
    final URL url = WebServerMain.class.getClassLoader().getResource(resourceName);
    final String warPath = url.getPath().replaceFirst("^file:", "").replaceFirst("!.*$", "");
    return warPath;
  }
}
