# HarmonyForgeInstallerCLI

## 为什么？

[Minecraft Forge](https://files.minecraftforge.net) 研发了史上最好的 Minecraft 扩展之一，做出了伟大的贡献！

然而，Forge 的安装器在某些环境中工作不佳。

出于这种原因，我为 Alicorn 启动器专门编写了这个辅助工具。

该工具的作用就是从命令行启动 Forge 的安装程序，仅用于客户端（因为服务端的安装命令在 Forge 安装器中已经提供）。

我们**希望** Forge 是**疏忽**而没有做 `-installClient` 参数，而不是**为了某种利益故意移除了**这个参数，甚至为此（在某种程度上）牺牲用户的自由，这不是一个自由软件该做的事情。

> 自由之零：**不论目的为何**，有运行该软件的自由。

## 怎么做？

**注意：自 2021/07/29 开始，本项目不再在 Bitbucket 更新。**

首先，下载[最新的发行版](https://github.com/Andy-K-Sparklight/HarmonyForgeInstallerCLI/releases)。

然后，下载你需要的 Forge 安装器。目前，1.16.5 和 1.12.2 的安装器已经通过测试，但理论上 1.12.2 至 1.16.5 的任何 Forge
版本都可以安装。由于 [MCBBS](https://www.mcbbs.net) 建议的「最低不过期版本」为 1.12.2，因此未测试 1.12.2 之前的版本（不含），但理论上也可以工作。

```shell
# Windows
java -cp "<HarmonyForgeInstallerCLI 的位置>;<Forge 安装器的位置>" rarityeg.alicorn.ForgeInstallerWrapper "<要安装到的 Minecraft 文件夹>"

# macOS 和 GNU/Linux，仅仅把分号改成冒号
java -cp "<HarmonyForgeInstallerCLI 的位置>:<Forge 安装器的位置>" rarityeg.alicorn.ForgeInstallerWrapper "<要安装到的 Minecraft 文件夹>"
```

## 输出

HarmonyForgeInstallerCLI 保留了原始输出，未作任何更改。如果程序运行出错，会输出来自 HarmonyForgeInstallerCLI 的堆栈追踪。

退出代码可能是：

- 0：安装成功完成（Forge 安装器没有提交错误）。
- 1：安装出现错误（任何错误）。
- 其它：HarmonyForgeInstallerCLI 不会主动返回其它数值，但如果运行环境决定这样做，可能返回其它的值。

## 编译

要编译 HarmonyForgeInstallerCLI，请这样做：

- OpenJDK/Java 版本：建议使用 Java 标准 8（字节码版本 52.0）进行编译，以免出现兼容性问题。

- ~~拉取 Forge 安装器的官方仓库，并手动编译代码（不建议使用 Forge 提供的
  Gradle，使用常规编译方法即可）：`git clone https://github.com/MinecraftForge/Installer.git`~~
  
  现在 HarmonyForgeInstallerCLI 已经全面改用反射编写，故不再需要使用原始安装器进行编译。

- 拉取本仓库：`git clone https://github.com/Andy-K-Sparklight/HarmonyForgeInstallerCLI.git`

- ~~在本仓库中添加从 Forge 安装器中构建的 Jar（例如使用 IDEA 的 Libraries），其中需要包含以下类：~~（现在不再需要了）

  ```
  net.minecraftforge.installer.SimpleInstaller;
  net.minecraftforge.installer.actions.ClientInstall;
  net.minecraftforge.installer.actions.ProgressCallback;
  net.minecraftforge.installer.json.Install;
  net.minecraftforge.installer.json.Util;
  ```

- 使用常规方法编译本仓库并打包为 Jar 包，便可以在你的项目中使用它了！

预编译的 Jar 文件所使用的编译工具：

```
openjdk version "1.8.0_282"
OpenJDK Runtime Environment (build 1.8.0_282-b08)
Eclipse OpenJ9 VM (build openj9-0.24.0, JRE 1.8.0 Windows 8.1 amd64-64-Bit Compressed References 20210120_972 (JIT enabled, AOT enabled)
OpenJ9   - 345e1b09e
OMR      - 741e94ea8
JCL      - ab07c6a8fd based on jdk8u282-b08)
```

## 许可

> 是的，把它贡献出来。

本项目使用 GNU 通用公共许可证（第三版，GPL-3.0）授权，**没有任何保证**
，您可以自由地（包括但不限于）修改，使用和重新分发它，这些行为有一些前提，详情参阅 https://www.gnu.org/licenses/gpl-3.0.html

## 本项目作者

[RarityEG](https://www.mcbbs.net/home.php?mod=space&uid=3281025)：MCBBS 的一只小马~
