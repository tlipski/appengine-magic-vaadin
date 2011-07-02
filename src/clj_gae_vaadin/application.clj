(ns clj_gae_vaadin.application
  "Tools for local development.
   Enables the use of the App Engine APIs on the REPL and in a local Jetty instance."
  (:import [com.vaadin Application]))


(defn main-wrap []
  (proxy [com.vaadin.Application] []
    (init []
      (let [app this]
        (.setMainWindow this
          (doto (new com.vaadin.ui.Window "Test application4")
            (.addComponent
              (new com.vaadin.ui.Label "Hello Vaadin/LISP user!"))
            (.addComponent
              (doto (new com.vaadin.ui.Button "button")
                (.addListener (proxy [com.vaadin.ui.Button$ClickListener] []
                  (buttonClick [event] (. (. app (getMainWindow)) (showNotification "test")))))))))))))

(defn main []
  (main-wrap))
