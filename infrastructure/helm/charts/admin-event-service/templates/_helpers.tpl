{{- define "admin-event-service.name" -}}
admin-event-service
{{- end -}}

{{- define "admin-event-service.fullname" -}}
{{ include "admin-event-service.name" . }}-{{ .Release.Name }}
{{- end -}}
