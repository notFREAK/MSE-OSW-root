{{- define "public-event-service.name" -}}
public-event-service
{{- end -}}

{{- define "public-event-service.fullname" -}}
{{ include "public-event-service.name" . }}-{{ .Release.Name }}
{{- end -}}
