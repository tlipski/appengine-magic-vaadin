(ns appengine_magic.vaadin-servlet
  (:gen-class
    :name appengine_magic.vaadin_servlet
    :prefix ext-
    :extends com.vaadin.terminal.gwt.server.GAEApplicationServlet
    :exposes-methods {init initSuper}))

(defn ext-getApplicationClass [this] (class com.vaadin.Application))

(defn ext-init
  ([this]
    (.initSuper this))
  ([this servletConfig]
    (.initSuper this
      (proxy [javax.servlet.ServletConfig] []
        (getServletName [] (.getServletName servletConfig))
        (getServletContext [] (.getServletContext servletConfig))
        (getInitParameterNames [] (.getInitParameterNames servletConfig))
        (getInitParameter [key]
          (if (.equals "application" key)
            (.getName (class com.vaadin.Application))))))))


