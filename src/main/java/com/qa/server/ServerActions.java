package com.qa.server;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

public final class ServerActions {

    private static final ThreadLocal<AppiumDriverLocalService> server=new ThreadLocal<>();

    public static void startServer()
    {

        AppiumDriverLocalService server=getDeafultServerService();
        server.start();
        if(server==null || ! server.isRunning())

        {
            throw new AppiumServerHasNotBeenStartedLocallyException("Server Not Started :: Aborted");
        }
        server.clearOutPutStreams();
        ServerActions.server.set(server);
    }

    public static AppiumDriverLocalService getServerInstance()
    {
        return ServerActions.server.get();
    }


    private ServerActions() {
    }

    private static AppiumDriverLocalService getDeafultServerService() {
         return AppiumDriverLocalService.buildDefaultService();

    }

    private static AppiumDriverLocalService getCustomisezServerService(int port) {
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                .withAppiumJS(new File("C:\\Users\\DELL\\AppData\\Roaming\\npm\\node_modules\\appium"))
                .usingPort(port)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
        );
    }

    public static boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

}
