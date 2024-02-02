package rarityeg.alicorn;

public class ForgeInstallerWrapper {
    public static void main(String[] args) {
        String path;
        if (args.length == 0) {
            path = ".";
        } else {
            path = args[0];
        }
        System.exit(getProperInstaller().installClient(path));
    }

    public static int install(String path) {
        return getProperInstaller().installClient(path);
    }

    private static AbstractForgeInstaller getProperInstaller() {
        final String[] method1 = {"net.minecraftforge.installer.VersionInfo", "net.minecraftforge.installer.InstallerAction", "com.google.common.base.Predicates", "com.google.common.base.Predicate"};
        final String[] method2 = {"net.minecraftforge.installer.json.Util", "net.minecraftforge.installer.json.InstallV1", "net.minecraftforge.installer.actions.ProgressCallback", "net.minecraftforge.installer.actions.ClientInstall", "net.minecraftforge.installer.SimpleInstaller"};
        final String[] method3 = {"net.minecraftforge.installer.json.Util", "net.minecraftforge.installer.json.Install", "net.minecraftforge.installer.actions.ProgressCallback", "net.minecraftforge.installer.actions.ClientInstall", "net.minecraftforge.installer.SimpleInstaller"};
        if (Util.wantClass(method1)) {
            return new Method1();
        }
        if (Util.wantClass(method2)) {
            return new Method2();
        }
        if (Util.wantClass(method3)) {
            return new Method3();
        }
        return new Method4();
        // This ancient method does not work now since some mirrors have been removed...
        // But we should at least let users know it's not our fault :(
    }
}
