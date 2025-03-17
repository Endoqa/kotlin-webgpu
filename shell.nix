{ pkgs ? import <nixpkgs> {

} }:
pkgs.mkShell.override { stdenv = pkgs.clangStdenv; } {

  LD_LIBRARY_PATH = pkgs.lib.makeLibraryPath (with pkgs; [
    wayland
    libxkbcommon
    vulkan-loader
    vulkan-validation-layers
  ]);

  nativeBuildInputs = with pkgs.buildPackages; [
    libGL

    vulkan-headers
    vulkan-loader
    vulkan-tools-lunarg
    vulkan-validation-layers

    wayland.dev
    wayland-scanner.dev
    libxkbcommon

    xorg.libXinerama
    xorg.libXcursor
    xorg.libXrandr
    mesa
    xorg.libX11.dev
    xorg.libxcb.dev
    xorg.libXi.dev

    pkg-config

  ];

}
