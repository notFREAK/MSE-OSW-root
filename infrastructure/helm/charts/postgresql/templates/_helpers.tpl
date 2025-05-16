{{- define "postgresql.name" -}}
{{ .Chart.Name }}
{{- end -}}

{{- define "postgresql.fullname" -}}
{{ printf "%s-%s" .Release.Name .Chart.Name | trunc 63 | trimSuffix "-" }}
{{- end -}}