(ns ring.util.anti-forgery
  (:use [hiccup core form def]
        ring.middleware.anti-forgery))

(defn anti-forgery-field
  "Create a hidden field with the session anti-forgery token as its value.
  This ensures that the form it's inside won't be stopped by the anti-forgery
  middleware."
  []
  (html (hidden-field "__anti-forgery-token" *anti-forgery-token*)))

(defhtml anti-forgery-metas
  "Create meta tags for specifying an anti-forgery-token values to be put in
  request headers."
  []
  [:meta {:name "csrf_header" :content "X-Anti-Forgery-Token"}]
  [:meta {:name "csrf_token" :content *anti-forgery-token*}])
