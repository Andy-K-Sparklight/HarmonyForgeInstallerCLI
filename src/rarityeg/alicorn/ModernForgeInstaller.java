package rarityeg.alicorn;

import net.minecraftforge.installer.SimpleInstaller;
import net.minecraftforge.installer.actions.ClientInstall;
import net.minecraftforge.installer.actions.ProgressCallback;
import net.minecraftforge.installer.json.Install;
import net.minecraftforge.installer.json.Util;

import java.io.File;

public class ModernForgeInstaller {
    public static int installClient(String path) {
        Install profile = Util.loadInstallProfile();
        ClientInstall clientInstall = new ClientInstall(profile, ProgressCallback.withOutputs(System.out));
        SimpleInstaller.headless = true;
        try {

            if (clientInstall.run(new File(path), (a) -> true)) {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }
}
