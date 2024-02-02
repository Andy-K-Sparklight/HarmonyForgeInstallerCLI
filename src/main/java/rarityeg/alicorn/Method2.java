package rarityeg.alicorn;

import java.io.File;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.function.Predicate;

public class Method2 extends AbstractForgeInstaller {
    @Override
    public  int installClient(String path) {
        try {
            Class<?> cUtil = Class.forName("net.minecraftforge.installer.json.Util");
            Class<?> cInstall = Class.forName("net.minecraftforge.installer.json.InstallV1");
            Class<?> cProgressCallback = Class.forName("net.minecraftforge.installer.actions.ProgressCallback");
            Class<?> cClientInstall = Class.forName("net.minecraftforge.installer.actions.ClientInstall");
            Class<?> cSimpleInstaller = Class.forName("net.minecraftforge.installer.SimpleInstaller");
            Method mLoadInstallProfile = cUtil.getMethod("loadInstallProfile");
            Object profile = mLoadInstallProfile.invoke(null);
            Constructor<?> conClientInstall = cClientInstall.getConstructor(cInstall, cProgressCallback);
            Method mWithOutputs = cProgressCallback.getMethod("withOutputs", OutputStream[].class);
            OutputStream[] os = {System.out};
            Object output = mWithOutputs.invoke(null, (Object) os);
            Object clientInstall = conClientInstall.newInstance(profile, output); // ClientInstall
            Field headless = cSimpleInstaller.getField("headless");
            headless.setBoolean(null, true);
            Method mRun = cClientInstall.getMethod("run", File.class, Predicate.class, File.class);
            Predicate<?> p = o -> true;
            Object state = mRun.invoke(clientInstall, new File(path), p, new File(""));
            if ((boolean) state) {
                return 0;
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }
}
