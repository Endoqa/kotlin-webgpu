let
  pkgs = import <nixpkgs> { };
  ts_grammars =
    pkgs.tree-sitter.withPlugins (p: [ ]);

  ts = pkgs.tree-sitter;

in {

}:
pkgs.mkShell {

  nativeBuildInputs = with pkgs; [ ts_grammars ts ];

  TREE_SITTER_PATH = "${ts}";

  TREE_SITTER_GRAMMAR_PATH = "${ts}";
}
