package rarityeg.alicorn;

public class ForgeInstallerWrapper {
    public static void main(String[] args) {
        String path;
        if (args.length == 0) {
            path = ".";
        } else {
            path = args[0];
        }
        if (isLegacy()) {
            System.exit(LegacyForgeInstaller.installClient(path));
        } else if (isMedium()) {
            System.exit(MediumForgeInstaller.installClient(path));
        } else {
            System.exit(ModernForgeInstaller.installClient(path));
        }
    }

    private static boolean isLegacy() {
        try {
            Class.forName("net.minecraftforge.installer.actions.ClientInstall");
            return false;
        } catch (Exception ignored) {
            return true;
        }
    }

    private static boolean isMedium() {
        try {
            Class.forName("net.minecraftforge.installer.json.InstallV1");
            return false;
        } catch (Exception ignored) {
            return true;
        }
    }
}
