(set-env!
  :source-paths #{"src"}
  :resource-paths #{"resources"}
  :dependencies '[[org.clojure/clojure "1.8.0"]])

(task-options!
  pom {:project '{{app-name}}
       :version "0.1.0-SNAPSHOT"
       :description "FIXME: write description"}
  aot {:namespace #{'{{namespace}}}}
  jar {:main '{{namespace}}})

(require '{{namespace}})

(deftask run []
  (comp
    (with-pre-wrap fileset
      ({{namespace}}/-main)
      fileset)))

(deftask build []
  (comp (aot) (pom) (uber) (jar) (target)))

