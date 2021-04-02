package rarityeg.alicorn;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LegacyForgeInstaller {
    public static int installClient(String path) {
        try {
            Class<?> versionInfoC = Class.forName("net.minecraftforge.installer.VersionInfo");
            Method getVersionTargetM = versionInfoC.getMethod("getVersionTarget");
            getVersionTargetM.invoke(null);
            Class<?> installerActionC = Class.forName("net.minecraftforge.installer.InstallerAction");
            Object[] installerActionE = installerActionC.getEnumConstants();
            Method getName = installerActionC.getMethod("name");

            Class<?> gpC = Class.forName("com.google.common.base.Predicates");
            Class<?> gpCS = Class.forName("com.google.common.base.Predicate");
            Method makeRunM = installerActionC.getMethod("run", File.class, gpCS);
            Method alwaysTrueM = gpC.getMethod("alwaysTrue");
            Object predicateI = alwaysTrueM.invoke(null);
            for (Object o : installerActionE) {
                Object iaCurrent = installerActionC.cast(o);
                String name = (String) getName.invoke(iaCurrent);
                if (name.equals("CLIENT")) {
                    if ((boolean) makeRunM.invoke(iaCurrent, new File(path), gpCS.cast(predicateI))) {
                        return 0;
                    }
                }
            }

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return 1;
    }

}
