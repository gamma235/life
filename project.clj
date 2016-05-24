(defproject life "0.1.0-SNAPSHOT"
  :description "2D Game of Life command line app"
  :url "https://github.com/gamma235/life"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot life.core
  :aot [life.core])
