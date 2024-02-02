package rarityeg.alicorn;

import java.io.File;
import java.lang.reflect.Method;

public class Method4 extends AbstractForgeInstaller {
    @Override
    public int installClient(String path) {
        try {
            Class<?> versionInfoC = Class.forName("net.minecraftforge.installer.VersionInfo");
            Method getVersionTargetM = versionInfoC.getMethod("getVersionTarget");
            getVersionTargetM.invoke(null);
            Class<?> installerActionC = Class.forName("net.minecraftforge.installer.InstallerAction");
            Object[] installerActionE = installerActionC.getEnumConstants();
            Method getName = installerActionC.getMethod("name");
            Method makeRunM = installerActionC.getMethod("run", File.class);
            for (Object o : installerActionE) {
                Object iaCurrent = installerActionC.cast(o);
                String name = (String) getName.invoke(iaCurrent);
                if (name.equals("CLIENT")) {
                    if ((boolean) makeRunM.invoke(iaCurrent, new File(path))) {
                        return 0;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 1;
    }
}
