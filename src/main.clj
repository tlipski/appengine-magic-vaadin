(require '[appengine-magic.core :as ae])

(in-ns 'clojure.core)
(def *compile-files* true)
(load-file "src/clj_gae_vaadin/application.clj")

(appengine-magic.core/def-appengine-vaadin-app v1 clj_gae_vaadin.application/main)
(appengine-magic.core/serve v1)

